env.PROJECT_GIT_NAME = 'GBI_POC_WORK'
env.PROJECT_NAME = env.PROJECT_GIT_NAME.toLowerCase()
env.JOB = 'test'
env.VERSION = '0.2'
env.GIT_URL = 'https://github.com/vikrammatle/GBIPOCWORK.git'
env.TYPE = "" // if big data = _mr n
env.DOCKERHUB_USER = "talendinc"
env.imageName= 'talendrahulpoc'
env.registry='506623706255.dkr.ecr.ap-south-1.amazonaws.com'


// Credentials IDs (Manage Jenkins => Credentials)
env.GIT_CREDENTIALS_ID = 'github'

node {
 	// Clean workspace before doing anything
    try {
        def userInput
        def deployprod
        stage('Initialize') {
            sh '''
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
            ''' 
        }
        stage ('Git Checkout') {
            git(
                url: "${GIT_URL}",
                credentialsId: "${GIT_CREDENTIALS_ID}",
                branch: 'master'
            )       
            mvnHome = tool 'mvn'
        }
        stage ('Build, Test and Publish Jobs to Nexus') {
                    withMaven(
                            // Maven installation declared in the Jenkins "Global Tool Configuration"
                            maven: 'mvn',
                            // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
                            // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
                           // mavenSettingsConfig: 'maven-file',
                            mavenOpts: '-Dupdatesite.path=http://15.206.73.221:8082/P2/ -Dlicense.path=/opt/remote.license -Dgeneration.type=local  -Dservice.url=https://tmc.ap.cloud.talend.com/inventory/ -Dcloud.publisher.environment=TALEND_CICD_TEST -Dcloud.publisher.workspace=TALENDCICDTEST -Dservice.username=mansoorahmed.shaik@mail.nissan.co.jp -Dservice.password=chaitu@5B7 -Dcloud.publisher.screenshot=true -DaltDeploymentRepository=id::default::http://admin:admin123@35.154.250.197:8081/repository/Releases/ -Xms1024m -Xmx3096m') 
                            {
                    
                        // Run the maven test build
                        sh "mvn -s /opt/settings.xml -f $PROJECT_GIT_NAME/poms/pom.xml clean -Pcloud-publisher deploy"
                    
                        }  
        }
     
     stage ('building the docker image') {
               script{
                    sh "pwd"
                    sh "ls -l"
                    dir("./GBI_POC_WORK") {
                    docker.build(imageName, "-f DockerFile .")
                    }
            }
        }
     /*
      	stage("Push to Registry") {
                script {
                    sh "eval \$(aws ecr get-login --region ap-south-1 --no-include-email)"
                    sh "aws ecr describe-repositories --region ap-south-1 --repository-names $imageName || aws ecr create-repository --region ap-south-1 --repository-name $imageName"
                    docker.withRegistry(registry) {
                        docker.image(imageName).push('latest')
                    }
                    //sh "/var/lib/jenkins/bin/aws ecr list-images --region $REGION --repository-name $imageName --filter tagStatus=UNTAGGED --query 'imageIds[*]' --output text | while read imageId; do /var/lib/jenkins/bin/aws ecr batch-delete-image --region $REGION --repository-name $imageName --image-ids imageDigest=\$imageId; done"
                }
        }
     stage("Deploy to DEV") {
            script {
                sh "eval \$(aws ecr get-login --region ap-south-1 --no-include-email)"
                sh "/usr/bin/aws --version"
                sh "/usr/bin/aws ecs register-task-definition --cli-input-json file://IB5-taskdef-js.json" 
               // sh "/usr/bin/aws ecs run-task --cluster IB5-Talendcicd-cluster-demo --count 1 --launch-type FARGATE --network-configuration awsvpcConfiguration={subnets=[subnet-015ea77f6d4584ac7],securityGroups=[sg-036076fbc4e9ed4b1],assignPublicIp=ENABLED} --task-definition fargate-task-definition"
            }
        }
  */
    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}
