def call(Map parameters) {
    //access stage name
    echo "Start - Extension for stage: ${parameters.stageName}"

    try {
        // execute original stage as defined in the template
        parameters.originalStage()

        configureGithubCall(parameters, 'success')
    } catch (Exception e) {
        configureGithubCall(parameters, 'failure')
    }

    echo "End - Extension for stage: ${parameters.stageName}"
}

def configureGithubCall(parameters, status) {
    githubSetCommitStatus(
      script: parameters.script,
      commitId: env.GIT_COMMIT_TO_BE_BUILT,
      context: 'release',
      status: status,
      description: 'continuous-integration/release',
      targetUrl: env.UI_SELF_LINK
    )
}

return this
