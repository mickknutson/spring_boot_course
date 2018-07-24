#-----------------------------------------------------------------------------#
# Create custom-maven-settings.xml
#-----------------------------------------------------------------------------#
# Offline mode set to TRUE by default:

%JAVA_HOME%\bin\java java -jar MavenSettingsInitializer.jar

#-----------------------------------------------------------------------------#
# Offline mode set to FALSE:
%JAVA_HOME%\bin\java java -jar MavenSettingsInitializer.jar false

#-----------------------------------------------------------------------------#
