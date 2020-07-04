Add a menu entry for activities
When clicking on the menu entry display a table
a table displays rows
every row represents an activity which calls this activity
the user can double click a row which will jump to the selected activity 

Things to be checked

- use the provided eclipse bundle for development
- project has to be built with java 1.8 (check compiler settings, and install adoptedopenjdk, and set
it to default java)
- project has to have the binaries in the same directory as eclipse workspace 
  - it won't load the files otherwise
  - git clone into workspace directory and import it (ugly hack) or
  - setup where magicdraw looks for classes
- project has to be added to "magicdraw with all plugins"  
  - properties -> java build path -> projects
 