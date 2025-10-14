# 📰 NotiLytics
*A Play Framework Web App for SOEN 6441 — Delivery 1*

---

## 🧩 Project Overview
**NotiLytics** is a web application built with the **Play Framework (Java + Scala)**.  
It retrieves news articles based on user keywords using the **NewsAPI**, processes data using **Java Streams**,  
and displays results through a responsive web interface.

---

## ⚙️ Environment Setup

### 🧱 Prerequisites
Before running the project, make sure you have the following installed:

| Tool | Version | Notes |
|------|----------|-------|
| **Java JDK** | 17 | Required by Play 2 |
| **sbt** | 1.9 or later | Scala Build Tool |
| **Scala** | 2.13 x | Installed automatically by sbt |
| **IntelliJ IDEA** | Community or Ultimate | With **Scala** and **Play Framework** plugins |
| **Git** | latest | For version control |

---

### 🧭 Step 1 — Clone the Repository

🧱 Step 2 — Open the Project in IntelliJ
1. Open IntelliJ IDEA → File → Open Project
2. Select the folder: SOEN_6441_proj/notilytics
3. IntelliJ will detect the build.sbt file and import it automatically.
4. When asked to choose a JDK, select JDK 17.
5. Wait for dependency download and indexing to complete.

▶️ Step 3 — Run the App
From **sbt shell**
1. Open the sbt Shell window at the bottom of IntelliJ.
2. Type:
   run
3. Another Option to use IntelleiJ terminal and type:
   sbt run
3. Wait until you see: (Server started at http://localhost:9000)
4. Open a browser and visit:
   👉 http://localhost:9000
   You should see the message “Welcome to Play!”

⚙️ Step 4: Common Fixes
1. If you see sbt not recognized in terminal → install sbt from https://www.scala-sbt.org/download.html
2. If dependencies fail → click Reload sbt Project in IntelliJ.
3. If Play shows a JWT cookie warning → clear cookies in your browser.