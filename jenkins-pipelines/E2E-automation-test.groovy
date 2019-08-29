#!groovy

node {
    stage('Git checkout') { // for display purposes
        git 'https://git.overstock.com/scm/clubo/earlyaccess-automation-testing.git'
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
    stage('Results') {
        junit '**/target/failsafe-reports/*.xml'
    }
}
