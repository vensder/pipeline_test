def call(String message = 'usage sendToSlack in pipeline: \
	sendToSlack (<message>, <channel>, <color>)',
	String channel = '#devops', 
	String color = '#439FE0') {
	
	slackSend (
	    channel: channel,
	    color: color,
	    message: message, 
	    teamDomain: 'your-team', 
	    tokenCredentialId: 'here-token-id-from-jenkins-9f39-31fb244a3cd5'
	)

}
