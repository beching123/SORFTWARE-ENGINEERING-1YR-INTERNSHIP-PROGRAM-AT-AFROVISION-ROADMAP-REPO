#include <graphics.h>
#include <conio.h>

int main() {
    int gd = DETECT, gm;

    // Initialize graphics mode
    initgraph(&gd, &gm, "");  // Empty string for default path

    // Draw a rectangle with top-left corner (100, 100) and bottom-right corner (200, 150)
    rectangle(100, 100, 200, 150);

    // Draw a circle with center at (300, 200) and radius 50
    circle(300, 200, 50);

    // Display some text
    outtextxy(100, 50, "Simple Graphics Example");

    // Wait for user input
    getch();

    // Close the graphics mode
    closegraph();

    return 0;
}
