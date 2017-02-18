#!groovy
@Library('jenkins_scripts')

def slack_message = "Started ${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}>" + "\n" +
            "<${env.RUN_DISPLAY_URL}|Pipeline details>" + "\n" +
            "<${env.JOB_DISPLAY_URL}|Pipeline activity>"

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
        stage('Build') {
            steps {
                slackSend (
                    channel: '#devops', 
                    color: '#439FE0', 
                    message: slack_message, 
                    teamDomain: 'ehrworks', 
                    tokenCredentialId: '7c93fef5-8eee-4c70-9f39-31fb244a3cd5'
                )
                echo slackParams.team()
                sh 'echo "LABEL is: $LABEL"'
                sh 'echo "HOME is: $HOME"'
                sh 'echo "PWD is: $(pwd)"'
                sh 'echo "df is: $(df -h)"'
                sh 'echo "printenv is: $(printenv)"'
            }
        }
    }
}