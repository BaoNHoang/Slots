# 🎰 **Flower Slots!** 🌸💰  
_A vibrant Android slot machine game built with Java and Android Studio._

![Android Studio](https://img.shields.io/badge/Android%20Studio-2025-brightgreen?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=java&logoColor=white)
![Status](https://img.shields.io/badge/Status-Playable-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

## 🌼 **Overview**

Welcome to **Flower Slots** — the most *blooming exciting* slot machine on Android! 🌷  
Spin the reels, match flowers, and test your luck to hit the **triple bloom jackpot** 💸🌺  

This project showcases fun animation, clean Java logic, and a touch of casino-style excitement — all built in **Android Studio**.  

---

## 🌟 **Features**

✨ **Animated Slot Reels** — Gorgeous flower spins powered by `flower_spin.xml`.  
💵 **Smart Win System** — 3 matches = big win 🌸🌸🌸, 2 matches = smaller prize 🌼🌼❌.  
🌀 **Smooth Gameplay** — Tap “GO” and watch the flowers come alive!  
🔁 **Reset Anytime** — Go broke? No worries — start fresh instantly.  
📊 **Dynamic Balances** — Your total automatically updates every spin.  

---

## 🕹️ **Gameplay Rules**

1. 🎮 **Start with** `STARTUP_CASH` 💰  
2. ▶️ **Press "Go"** to spin (each spin costs `COST_PER_ROLL`).  
3. 🍀 **Win Conditions:**  
   - 🌸🌸🌸 **Match 3:** +`MATCH_3` cash! Jackpot!  
   - 🌼🌼❌ **Match 2:** +`MATCH_2` — still a win!  
   - ❌❌❌ **No Match:** Lose your spin cost 😭  
4. 💸 **Run out of money?**  
   - Tap **Reset 🔁** to restore your balance and play again!  

---

## ⚙️ **Game Constants**

Create a file named **`CONSTANTS.java`** and add:  

```java
public class CONSTANTS {
    public static final int STARTUP_CASH = 100;
    public static final int COST_PER_ROLL = 10;
    public static final int MATCH_2 = 20;
    public static final int MATCH_3 = 50;
    public static final int YOUR_BROKE = 0;
    public static final int NUMB_FLOWERS = 3;
}
```

## 🧩 Assets & Layout

🎨 Drawable Images
Place your flower images in:
app/src/main/res/drawable/



f1.png
f2.png
f3.png




🎞️ **Animation**

app/src/main/res/anim/flower_spin.xml — defines the spinning animation for the slot reels.

📱 **Layout**

app/src/main/res/layout/activity_main.xml should include:

- 3 ImageViews (for the reels)

- 1 TextView (for balance 💰)

- 2 ImageButtons (Go ▶️ and Reset 🔁)

## 🚀 How to Run

1. Open in Android Studio 🧑‍💻

2. Connect your Android device or launch an emulator 📱

3. Hit Run ▶️

Spin, match, and watch your cash bloom! 🌼💸
