#!/usr/bin/env groovy

@Library('jenkins_lib') _

def start_message = "Started ${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}>" + "\n" +
            "<${env.RUN_DISPLAY_URL}|Pipeline details>" + "\n" +
            "<${env.JOB_DISPLAY_URL}|Pipeline activity>"          

pipeline {
    agent any
    environment {
        MY_VAR = 'DEFINE_MY_ENV_VARIABLE'
    }
    stages {
        stage('Checkout') {
            steps {
                sendToSlack()
                sendToSlack('Checkout stage', '#devops', '#ABCDEF')
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
            }
        }
        stage('Build') {
            steps {
                slackSend (
                    channel: '#devops', 
                    color: '#439FE0', 
                    message: start_message, 
                    teamDomain: slackParams.teamDomain, 
                    tokenCredentialId: slackParams.tokenCredentialId
                )
                ansiColor('xterm') {
                    sh 'printenv'
                }
                print manager.build.number
                //print result
                //print completed
            }
        }
    }
    post {
        success {
            sendToSlack ('Pipeline finished successfully','#devops', 'good')
        }
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





