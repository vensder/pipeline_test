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
                node(label: 'ubuntu1604') {
                    sh 'echo "LABEL is: $LABEL"'
                }
            }
        }
    }
}