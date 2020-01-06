job('NodeJS example w JOB DSL') {
    scm {
        git('git://github.com/androidotai/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('androidotai')
            node / gitConfigEmail('androidotai@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
