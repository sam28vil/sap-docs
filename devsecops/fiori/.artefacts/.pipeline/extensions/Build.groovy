def call(Map parameters) {
    //access stage name
    echo "Start - Extension for stage: ${parameters.stageName}"

    try {
        configureGithubCall(parameters, 'pending', 'release')
        configureGithubCall(parameters, 'pending', 'build')

        // execute original stage as defined in the template
        parameters.originalStage()

        configureGithubCall(parameters, 'success', 'build')
    } catch (Exception e) {
        configureGithubCall(parameters, 'failure', 'release')
        configureGithubCall(parameters, 'failure', 'build')
    }

    echo "End - Extension for stage: ${parameters.stageName}"
}

def configureGithubCall(parameters, status, context) {
    githubSetCommitStatus(
      script: parameters.script,
      commitId: env.GIT_COMMIT_TO_BE_BUILT,
      context: context,
      status: status,
      description: "continuous-integration/${context}",
      targetUrl: env.UI_SELF_LINK
    )
}

return this
