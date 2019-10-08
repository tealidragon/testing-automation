#!groovy

def serenityTargetBasePath = 'serenity-ui-api-automated-testing' // base path to your '/target' folder where the serenity reports live
def serenityAppFolderName = 'serenity-ui-api-testing' // your report folder name. make it unique!


node {
    stage('Git checkout') { // for display purposes
        git 'https://github.com/tealidragon/testing-automation.git'
    }
    stage('Smoke') {
        try {
            sh "mvn clean verify -Dtags='type:Smoke'"
        } catch (err) {

        } finally {

            publishHTML(target: [
                    reportDir  : 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName : 'Smoke tests report',
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
                    reportDir  : 'target/site/serenity',
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
                    reportDir  : 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName : "API tests report",
                    keepAll:     true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
            ])
        }
    }
    stage('PeopleAPI') {
        try {
            sh "mvn clean verify -Dtags='type:PeopleAPI'"
        } catch (err) {

        } finally {
            publishHTML(target: [
                    reportDir  : 'target/site/ serenity',
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
                    reportDir: 'target/site/ serenity',
                    reportFiles: 'index.html',
                    reportName: "UI tests report",
                    keepAll:     true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
            ])
        }
    }
    stage('Publish Results') {
        sh "cd ${serenityTargetBasePath}/target/site/serenity && find * -type f -exec curl -u daemon:xampp --ftp-create-dirs -T {} ftp://${serenityReportServer}/ftpUploads/${serenityAppFolderName}/serenity/{} \\;"
        sh "curl -X GET http://${serenityReportServer}:8080/archive/${serenityAppFolderName}/serenity"
        echo "Link to live report: http://${serenityReportServer}:8080/reports/${serenityAppFolderName}/live/index.html"
        currentBuild.description = "Click <a href='http://${serenityReportServer}:8080/${serenityAppFolderName}/live'>here</a> for Serenity Reports"
        sh "cd ../../../../"

        junit '**/target/failsafe-reports/*.xml'
    }
}
