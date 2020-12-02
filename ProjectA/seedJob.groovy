// seed job for xx system
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
      targets: 'ProjectA/jobs/*.groovy',
      unstableOnDeprecation: true
    )
  }
}