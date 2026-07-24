pipeline {
    agent any

    tools{
        maven "Maven"
    }

    stages {
        stage('Maven Build'){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Run Tests'){
            steps{
                sh 'mvn test'
            }
        }
    }
}