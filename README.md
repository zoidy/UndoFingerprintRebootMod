Xposed module to revert the [Galaxy Rom Oreo ROM](https://forum.xda-developers.com/galaxy-s7/development/rom-galaxy-project-t3792761) Mod to allow fingerprint unlock after reboot. It probably works on any Samsung Oreo ROM with this mod. It requires Xposed > 53. XposedInstaller should also be installed. It also works with Magisk Xposed. 

To compile this app, use the AIDE tool on the phone
1. follow step 3 from [here](https://forum.xda-developers.com/showthread.php?t=2637006) to set up AIDE for Xposed development. Step 2 is only if we're creating a new project. The project was adapted from the official Xposed development [tutorial](https://github.com/rovo89/XposedBridge/wiki/Development-tutorial)
1. Copy the contents of this repo to the AppProjects folder in the phone's internal storage that AIDE creates. 
1. Run the project to compile and install.
1. If you have XposedInstaller installed, it should detect the new module and prompt to reboot.

Tool used to examine the original rom SystemUI.apk: jadx 1.0