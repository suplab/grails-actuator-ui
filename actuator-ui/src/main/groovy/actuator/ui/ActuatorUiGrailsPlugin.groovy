package actuator.ui

import org.grails.plugins.actuator.ui.ActuatorEndpointsConfig
import grails.plugins.*

class ActuatorUiGrailsPlugin extends Plugin {
    def version = "1.0"
    def grailsVersion = "3.1.0 > *"
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Actuator UI"
    def author = "Dhiraj Mahapatro"
    def authorEmail = "dhiraj.mahapatro@gmail.com"
    def description = '''\
Actuator UI is the UI representation of Spring Boot actuator endpoints for an app.
The response from HTTP endpoints available in a Grails 3 (Spring Boot) app is projected in a user friendly administration console.
'''
    def profiles = ['web']
    def documentation = "http://grails.org/plugin/actuator-ui"
    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/dmahapatro/grails-actuator-ui/issues" ]
    def scm = [ url: "https://github.com/dmahapatro/grails-actuator-ui/" ]

    Closure doWithSpring() { {->
            actuatorUiConfig(ActuatorEndpointsConfig) {
                endpointsProperties = config.getProperty('endpoints', Map, [:])
                managementProperties = config.getProperty('management', Map, [:])
            }
        } 
    }
}
