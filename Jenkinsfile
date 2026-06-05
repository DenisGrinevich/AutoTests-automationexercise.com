pipeline {
    agent any
parameters {
    choice(name: 'TEST_GROUP', choices: ['smoke', 'full'], description: 'Группа тестов')
}

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
            }

        stage('Build') {
            steps {
                sh 'echo "Сборка..."'
                sh 'mvn clean compile'
            }
        }

        stage('TestPR') {
            when {
                allOf {
                    changeRequest()
                    expression { env.CHANGE_TARGET in ['main', 'master'] }
                }
            }
            steps {
                echo "Pull Request to ${env.CHANGE_TARGET}"
                sh 'mvn clean test'
            }
        }
       stage('Test') {
            when {
                allOf {
                    not { changeRequest() }
                    expression {
                        return currentBuild.buildCauses.toString().contains('UserIdCause')
                    }
                }
            }
            steps {
                script {
                    echo "Manual run on ${env.BRANCH_NAME} - running ${params.TEST_GROUP} suite"
                    if (params.TEST_GROUP == 'full') {
                        sh 'mvn clean test'
                    } else {
                        sh "mvn clean test -Dsurefire.suiteXmlFiles=testng-${params.TEST_GROUP}.xml"
                    }
                }
            }
        }
    }
    post {
    always {
        allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/allure-results']]
        ])
    }
}
}
