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
                    reportName : "Smoke tests report",
                    keepAll:     true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
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
                    reportName : "DB tests report",
                    keepAll:     true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
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
                    reportName : "API tests report",
                    keepAll:     true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
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
                    reportName: "UI tests report",
                    keepAll:     true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
            ])
        }
    }
    stage('Results') {
        junit '**/target/failsafe-reports/*.xml'
    }
}
