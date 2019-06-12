node('maven') {
  stage('Build') {
    git url: "https://github.com/hakimo003/spring_boot_mysql_sample.git"
    sh "mvn package"
    stash name:"jar", includes:"target/easy-notes.jar"
  }
  stage('Build Image') {
    unstash name:"jar"
    sh "oc start-build cart --from-file=target/easy-notes.jar --follow"
  }
  stage('Deploy') {
    openshiftDeploy depCfg: 'cart'
    openshiftVerifyDeployment depCfg: 'cart', replicaCount: 1, verifyReplicaCount: true
  }
}
