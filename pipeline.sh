


pipeline {
    agent any
    stages{
    stage('List File'){
    steps{
    sh 'ls -l'
 }
}
}
}
