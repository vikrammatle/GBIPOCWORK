env.PROJECT_GIT_NAME = 'GBI_POC_WORK'
env.PROJECT_NAME = env.PROJECT_GIT_NAME.toLowerCase()
env.JOB = 'test'
env.VERSION = '0.2'
env.GIT_URL = 'https://github.com/vikrammatle/GBIPOCWORK.git'
env.TYPE = "" // if big data = _mr n
env.DOCKERHUB_USER = "talendinc"
env.imageName= 'talendimagenew'
env.registry='http://464598779341.dkr.ecr.ap-south-1.amazonaws.com'


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
                            mavenOpts: '-Dupdatesite.path=http://13.232.107.133:8082/P2/ -Dlicense.path=/opt/remote.license -Dgeneration.type=local  -Dservice.url=https://tmc.ap.cloud.talend.com/inventory/ -Dcloud.publisher.environment=TALEND_CICD_TEST -Dcloud.publisher.workspace=TALENDCICDTEST -Dservice.username=mansoorahmed.shaik@mail.nissan.co.jp -Dservice.password=chaitu@5B7 -Dcloud.publisher.screenshot=true -DaltDeploymentRepository=id::default::http://admin:admin123@35.154.250.197:8081/repository/Releases/ -Xms1024m -Xmx3096m') 
                            {
                    
                        // Run the maven test build
                        sh "mvn -s /opt/settings.xml -f $PROJECT_GIT_NAME/poms/pom.xml clean -Pcloud-publisher deploy"
                    
                        }  
        }
  
    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}
