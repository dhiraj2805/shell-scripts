Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@dhiraj2805 
linuxautomations
/
jenkins-docker-groovy
2
021
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
jenkins-docker-groovy/plugins.groovy
@linuxautomations
linuxautomations Create plugins.groovy
Latest commit bf6ca5a 14 days ago
 History
 1 contributor
36 lines (36 sloc)  1002 Bytes
  
import jenkins.model.*
import java.util.logging.Logger
def logger = Logger.getLogger("")
def installed = false
def initialized = false
def pluginParameter="git seed authorize-project workflow-aggregator blueocean"
def plugins = pluginParameter.split()
logger.info("" + plugins)
def instance = Jenkins.getInstance()
def pm = instance.getPluginManager()
def uc = instance.getUpdateCenter()
plugins.each {
  logger.info("Checking " + it)
  if (!pm.getPlugin(it)) {
    logger.info("Looking UpdateCenter for " + it)
    if (!initialized) {
      uc.updateAllSites()
      initialized = true
    }
    def plugin = uc.getPlugin(it)
    if (plugin) {
      logger.info("Installing " + it)
      def installFuture = plugin.deploy()
      while(!installFuture.isDone()) {
        logger.info("Waiting for plugin install: " + it)
        sleep(3000)
      }
      installed = true
    }
  }
}
if (installed) {
  logger.info("Plugins installed, initializing a restart!")
  instance.save()
  instance.restart()
}
© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
