pipeline {
  agent any
  
  stages{
   stage('Compile Stage'){
    steps{
      mvn clean compile
    }
   }
   stage('Test Stage'){
    steps{
      mvn test
    }
   }
   stage('Deployment Stage'){
    steps{
      mvn deploy
    }
   }
  }
}
