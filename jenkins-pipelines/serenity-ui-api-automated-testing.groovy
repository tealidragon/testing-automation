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

        }
    }
    stage('Db') {
        try {
            sh "mvn clean verify -Dtags='type:DB'"
        } catch (err){

        }

    }
    stage('API') {
        try {
            sh "mvn clean verify -Dtags='type:API'"
        } catch (err){

        }

    }
    stage('PeopleAPI') {
        try {
            sh "mvn clean verify -Dtags='type:PeopleAPI'"
        } catch (err){

        }

    }
    stage('UI') {
        try {
            sh "mvn clean verify -Dtags='type:UI'"
        } catch (err){

        }

    }
    stage('Publish Results') {
        publishHTML(target: [
                reportDir  : './target/site/serenity',
                reportFiles: 'index.html',
                keepAll:     true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
        ])
//        junit '**/target/failsafe-reports/*.xml'
    }
}
