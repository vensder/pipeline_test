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
                    message: "\
started ${env.JOB_NAME} \
${env.BUILD_NUMBER} \
(<${env.BUILD_URL}|Open>)", 
                    teamDomain: 'ehrworks', 
                    tokenCredentialId: '7c93fef5-8eee-4c70-9f39-31fb244a3cd5'
                )
                echo 'hello'
                sh 'echo "LABEL is: $LABEL"'
                sh 'echo "HOME is: $HOME"'
                sh 'echo "PWD is: $(pwd)"'
                sh 'echo "df is: $(df -h)"'
                sh 'echo "printenv is: $(printenv)"'
            }
        }
    }
}