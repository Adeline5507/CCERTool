package com.thomsonreuters.ccertool;


public class Main {
  
        public static void main(String[] args) throws Exception {
            if (args.length > 0 && "stop".equals(args[0])) {
                AppContextController.stopContext();
                System.exit(0);
            } else {
                AppContextController.loadAndStartContext(AppContextController.DEFAULT_CONTEXT_DEFINITION_FILE);
            }
        }
}