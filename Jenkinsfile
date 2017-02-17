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
                echo 'hello'
                sh 'echo "LABEL is: $LABEL"'
            }
        }
    }
}