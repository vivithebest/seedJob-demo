node {
  stage('Checkout') {
    checkout scm
  }

  stage('Update') {
    jobDsl(
      failOnMissingPlugin: true,
      lookupStrategy: 'SEED_JOB',
      removedConfigFilesAction: 'DELETE',
      removedJobAction: 'DELETE',
      removedViewAction: 'DELETE',
      sandbox: true,
      targets: 'Project1/jobs/*.groovy',
      unstableOnDeprecation: true
    )
  }
}
