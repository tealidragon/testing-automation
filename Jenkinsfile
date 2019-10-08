#!/usr/bin/env groovy

def serenityReportServer = 'serenity-automated-testing.com' // your ftp / webserver
def serenityTargetBasePath = 'serenity-automated-testing-tests' // base path to your '/target' folder where the serenity reports live
def serenityAppFolderName = 'serenity-automated-testing' // your report folder name. make it unique!

node {
    stage('Git checkout') { // for display purposes
        git 'https://github.com/tealidragon/testing-automation.git'
    }
    stage('Smoke') {
        try {
            sh "mvn clean verify -Dtags='type:Smoke'"
        } catch (err) {

        } finally {

            publishHTML([
                    allowMissing         : false,
                    alwaysLinkToLastBuild: true,
                    escapeUnderscores    : false,
                    keepAll              : true,
                    reportDir  : 'serenity-automated-testing/target/site/serenity',
                    reportFiles: 'index.html',
                    reportName : 'Smoke tests report',
                    reportTitles         : 'Tests Report'
            ])
        }
    }
    stage('Db') {
        try {
            sh "mvn clean verify -Dtags='type:DB'"
        } catch (err) {

        } finally {
            publishHTML([
                    allowMissing         : false,
                    alwaysLinkToLastBuild: true,
                    escapeUnderscores    : false,
                    keepAll              : true,
                    reportDir  : 'serenity-automated-testing/target/site/serenity',
                    reportFiles: 'index.html',
                    reportName : "DB tests report",
                    reportTitles         : 'Tests Report'

            ])
        }
    }
    stage('API') {
        try {
            sh "mvn clean verify -Dtags='type:API'"
        } catch (err) {

        } finally {
            publishHTML([
                    allowMissing         : false,
                    alwaysLinkToLastBuild: true,
                    escapeUnderscores    : false,
                    keepAll              : true,
                    reportDir  : 'serenity-automated-testing/target/site/serenity',
                    reportFiles: 'index.html',
                    reportName : "API tests report",
                    reportTitles         : 'Tests Report'
            ])
        }
    }
    stage('PeopleAPI') {
        try {
            sh "mvn clean verify -Dtags='type:PeopleAPI'"
        } catch (err) {

        } finally {
            publishHTML([
                    allowMissing         : false,
                    alwaysLinkToLastBuild: true,
                    escapeUnderscores    : false,
                    keepAll              : true,
                    reportDir            : 'serenity-automated-testing/target/site/serenity',
                    reportFiles          : 'index.html',
                    reportName           : "PeopleAPIAPI tests report",
                    reportTitles         : 'Tests Report'

            ])
        }
    }
    stage('UI') {
        try {
            sh "mvn clean verify -Dtags='type:UI' -Dgrid=true"
        } catch (err) {

        } finally {
            publishHTML([
                    allowMissing         : false,
                    alwaysLinkToLastBuild: true,
                    escapeUnderscores    : false,
                    keepAll              : true,
                    reportDir            : 'serenity-automated-testing/target/site/serenity',
                    reportFiles          : 'index.html',
                    reportName           : "UI tests report",
                    reportTitles         : 'Tests Report'
            ])
        }
    }
}


