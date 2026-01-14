pipeline {
    agent any
parameters {
    choice(name: 'TEST_GROUP', choices: ['smoke', 'full'], description: 'Группа тестов')
}
    stages {
        stage('Build') {
            steps {
                sh 'echo "Сборка..."'
                sh 'mvn clean compile'
            }
        }

stage('Test') {
    steps {
        script {
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
