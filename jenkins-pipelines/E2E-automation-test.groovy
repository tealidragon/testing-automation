#!/usr/bin/env/groovy
@Library('ostk-pipeline')
import com.overstock.dx.Pipeline
@Library('ostk-pipeline')
import com.overstock.dx.Pipeline

def areDeploying = env.BRANCH_NAME == 'master'

new Pipeline(this).withMaven('3.5.0').withJava('8').execute {
    installWebhooks(scm)
    node {
        stage('Git checkout') { // for display purposes
            // Checkout code, cleaning the tree first if necessary
            ostkCheckout()
        }
        stage('Smoke') {
            try {
                sh "mvn clean verify -Dtags='type:Smoke'"
            } catch (err) {

            } finally {
                publishHTML(target: [
                        reportDir  : 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName : "Smoke tests report"
                ])
            }
        }
        stage('Db') {
            try {
                sh "mvn clean verify -Dtags='type:DB'"
            } catch (err) {

            } finally {
                publishHTML(target: [
                        reportDir  : 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName : "DB tests report"
                ])
            }
        }
        stage('API') {
            try {
                sh "mvn clean verify -Dtags='type:API'"
            } catch (err) {

            } finally {
                publishHTML(target: [
                        reportDir  : 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName : "API tests report"
                ])
            }
        }
        stage('UI') {
            try {
                sh "mvn clean verify -Dtags='type:UI'"
            } catch (err) {

            } finally {
                publishHTML(target: [
                        reportDir  : 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName : "UI tests report"
                ])
            }
        }
        stage('Results') {
            junit '**/target/failsafe-reports/*.xml'
        }
    }
}