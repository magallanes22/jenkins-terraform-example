node {
    
    
    stage("Getting code from github")
        git 'https://github.com/magallanes22/moduletwo'
    
    stage('Terraform init')
        sh 'terraform init'
    stage('Terraform Plan')
        input "Terraform Plan. CONTINUE?"
        sh "terraform plan -var-file='/var/jenkins_home/vars.tfvars'"
    stage('Terraform Apply')
        input "Terraform APLLY, CONTINUE?"
        sh "terraform apply -no-color -auto-approve -var-file='/var/jenkins_home/vars.tfvars'"
    stage('Terraform Destroy')
        input "Terraform Destroy, CONTINUE?"
        sh "terraform destroy -no-color -auto-approve -var-file='/var/jenkins_home/vars.tfvars'"
    
}
