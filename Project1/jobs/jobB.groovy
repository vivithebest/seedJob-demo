pipelineJob('ssss-pieline1') {
    description """OneApp iOS Build on
    <h2>
    With Tag
    </h2>
    """
    logRotator {
      artifactNumToKeep(30)
      numToKeep(30)
    }
}