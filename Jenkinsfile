#!groovy
@Library('jenkins_scripts')

def slack_message = "Started ${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}>" + "\n" +
            "<${env.RUN_DISPLAY_URL}|Pipeline details>" + "\n" +
            "<${env.JOB_DISPLAY_URL}|Pipeline activity>"
def env_vars = "${env.NODE_NAME}, ${env.GIT_BRANCH}, ${env.GIT_URL}"

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
                echo slackParams.teamDomain
                echo slackParams.tokenCredentialId
                slackSend (
                    channel: '#devops', 
                    color: '#439FE0', 
                    message: slack_message, 
                    teamDomain: slackParams.teamDomain, 
                    tokenCredentialId: slackParams.tokenCredentialId
                )
                print env_vars
                sh 'echo "LABEL is: $LABEL"'
                sh 'echo "NODE_LABELS is: $NODE_LABELS"'
                sh 'echo "hostname is $(hostname)"'
                sh 'echo "HOME is: $HOME"'
                sh 'echo "PWD is: $(pwd)"'
                sh 'echo "df is: $(df -h)"'
                sh 'echo "printenv is: $(printenv)"'
            }
        }
    }
}