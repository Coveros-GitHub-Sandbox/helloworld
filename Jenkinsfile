node {
  stage('SCM') {
    git 'https://github.com/dimitris-kavvathas-sonarsource/helloworld.git'
  }
  stage('SonarQube analysis') {
    def scannerHome = tool 'sq_scanner';
    withSonarQubeEnv('local') { // If you have configured more than one global server connection, you can specify its name
      sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=hello-world -Dsonar.login=sqa_47bb1b0b1d3187a9e842873fe7b5628bbcc66e1b"
    }
  }
}

// No need to occupy a node
stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}