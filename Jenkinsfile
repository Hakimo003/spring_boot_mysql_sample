node('maven') {
  stage('Build') {
    git url: "https://github.com/hakimo003/spring_boot_mysql_sample.git"
    sh "mvn package"
    stash name:"jar", includes:"target/easy-notes-1.0.0.jar"
  }
  stage('Build Image') {
    unstash name:"jar"
    sh "oc start-build cart --from-file=target/easy-notes-1.0.0.jar --follow"
  }
  stage('Deploy') {
    openshiftDeploy depCfg: 'easy-notes'
    openshiftVerifyDeployment depCfg: 'easy-notes', replicaCount: 1, verifyReplicaCount: true
  }
}
