[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/wPuP5asc)
# ICS3U CPT – Interactive Processing Project


## 📸 Program Screenshot
<img width="798" height="922" alt="Screenshot 2026-06-09 at 5 22 26 PM" src="https://github.com/user-attachments/assets/b1de2aae-2108-463a-b7f3-d77d932e85ce" />


---

## 🚘 Program Description
**Fast and Ferocious** is an arcade-style, vertical endless driving game built using the Processing library in Java. The player controls a high-speed vehicle navigating a busy three-lane highway, attempting to dodge oncoming red obstacles for as long as possible. 

The game features dynamic **difficulty scaling**:
* Every time you successfully pass an obstacle, your score increases by **100 points**.
* Every **500 points**, the game transitions to a harder difficulty level.
* With each new level, the highway lines speed up and the obstacle speeds increase, demanding faster reflexes from the driver.

---

## 🕹️ How to Interact
The game uses simple, responsive keyboard inputs to control the vehicle:

* **Move Left:** Press the **`A`** key to smoothly slide one lane to the left.
* **Move Right:** Press the **`D`** key to smoothly slide one lane to the right.
* **Restart Game:** If you crash into an obstacle, the game transitions to a "Game Over" screen. Press the **`SPACEBAR`** to reset your score, clear the board, reset the difficulty, and get back on the road.

---

## ⚠️ Known Limitations & Incomplete Features
While the core loop of *Fast and Ferocious* is fully playable, the current build has a few limitations:
* **Basic Collision Boxes:** Collision detection uses simplified absolute distance bounding boxes (`abs()`). At extremely high difficulty speeds, collisions might occasionally feel a bit tight or slightly not precise.
* **Visual Variety:** All oncoming obstacles use the exact same red rectangle asset. There are currently no power-ups (like shields or score multipliers) or different obstacle types.
* **Audio Assets:** The game currently runs completely silently; there are no background music tracks or crash sound effects implemented yet.

