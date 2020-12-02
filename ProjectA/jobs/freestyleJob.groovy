// create a new folder , same dir with the seed job
folder('tasks') {
    displayName('tasks4ProjectA')
    description('<h2>Folder for xxxx system Testing</h2>')
}


// create a freestyle project job 
job('ssss-freestyle1') {
    steps {
        shell('echo Hello World!')
    }
}