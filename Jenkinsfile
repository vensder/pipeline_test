#!/usr/bin/env groovy

@Library('jenkins_scripts') _

def slack_message = "Started ${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}>" + "\n" +
            "<${env.RUN_DISPLAY_URL}|Pipeline details>" + "\n" +
            "<${env.JOB_DISPLAY_URL}|Pipeline activity>"          
//def allBranches = scm.branches
//def gitBranch = scm.branches[0].name

pipeline {
    agent {
        label {
            label 'ubuntu1604'
        }
    }
    environment {
        LABEL = 'ubuntu1604'
    }
    stages {
        stage('Checkout') {
            steps {
                echo sendToSlack.chan
                sendToSlack.message 'Checkout Stage'
                echo sendToSlack.team
                checkout(
                    [
                        $class: 'GitSCM', 
                        branches: [[name: '*/master']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extensions: [], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [
                            [credentialsId: 'f51f83e4-f521-40fb-8aa6-6fce2ddf22d8', 
                            url: 'git@github.com:vensder/pipeline_test.git']
                        ]
                    ]
                )
                echo "Env vars is: ${env.NODE_NAME}, ${env.BRANCH_NAME}, ${env.GIT_URL}"
                sh 'echo "printenv is: $(printenv)"'
                //echo allBranches
            }
        }
        stage('Build') {
            steps {
                echo slackParams.teamDomain
                echo slackParams.tokenCredentialId
                slackSend (
                    channel: '#devops', 
                    color: '#439FE0', 
                    message: slack_message, 
                    teamDomain: slackParams.teamDomain, 
                    tokenCredentialId: slackParams.tokenCredentialId
                )
                sh 'echo "LABEL is: $LABEL"'
                sh 'echo "NODE_LABELS is: $NODE_LABELS"'
                sh 'echo "hostname is $(hostname)"'
                sh 'echo "HOME is: $HOME"'
                sh 'echo "PWD is: $(pwd)"'
                sh 'echo "df is: $(df -h)"'
            }
        }
    }
    post {
        failure {
            slackSend (
                channel: '#devops', 
                color: 'danger', 
                message: "Pipline failed", 
                teamDomain: slackParams.teamDomain, 
                tokenCredentialId: slackParams.tokenCredentialId
            )
        }
    }
}





