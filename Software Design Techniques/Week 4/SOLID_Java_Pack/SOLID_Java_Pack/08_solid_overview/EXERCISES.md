Goal: framing.

1) For each SOLID principle, write one sentence in your own words.
2) Pick ONE codebase you know and identify:
   - one place SRP is violated
   - one place DIP could reduce coupling
   Keep it short (a paragraph).


Windows Wallpaper manager, requires Windows File Explorer to function as intended.
This is because the desktop is a GUI subversion of windows file explorer.
This was written way back in the day and brought over through versions because many, many, many services and programs require this behaviour. This makes it very coupled and hard for microsoft to improve this functionality to follow best pratices