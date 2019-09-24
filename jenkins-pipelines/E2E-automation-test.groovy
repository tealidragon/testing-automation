#!/usr/bin/env groovy

node {
    stage('Git checkout') { // for display purposes
        git(
                url: 'https://git.overstock.com/scm/clubo/earlyaccess-automation-testing.git',
                credentialsId: 'b9cdfc06-1cbc-4d1d-b489-87414f67db3b',
                branch: 'master'
        )
    }
    stage('Smoke') {
        try {
            sh "mvn clean verify -Dtags='type:Smoke'"
        } catch (err) {

        } finally {

            publishHTML(target: [
                    reportDir  : 'target/site/thucydides',
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
                    reportDir  : 'target/site/thucydides',
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
                    reportDir  : 'target/site/thucydides',
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
            publishHTML (target: [
                    reportDir: 'target/site/thucydides',
                    reportFiles: 'index.html',
                    reportName: "UI tests report"
            ])
        }
    }
    stage('Results') {
        archiveArtifacts artifacts: '**/target/failsafe-reports/*.xml', fingerprint: true
        sh '*.xml'
        junit '**/target/failsafe-reports/*.xml'
    }
}
