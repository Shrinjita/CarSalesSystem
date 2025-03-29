### 🚗 **CarSalesSystem**

---

### 📚 **About the Project:**  
The **Car Sales System** is a **Java Swing-based GUI application** designed to manage and search car records. It allows users to add cars, search by various filters (age, price, and distance traveled), and display all cars in the system. The project uses Java’s **Swing** and **AWT** libraries to create an interactive and user-friendly interface.

---

### 🛠️ **Features:**
- **Add Cars:**  
  - Enter car details such as **model, manufacturer, year, price**, and **distance traveled**.  
- **Search Functionality:**  
  - Search cars by **age**, **price**, and **distance traveled**.  
  - Navigate through the results using **Previous** and **Next** buttons.  
- **Show All Cars:**  
  - View the complete list of cars in the system.  
- **Statistics Display:**  
  - Shows **total cars**, **manufacturers**, **average price**, **distance**, and **age**.  
- **File Management:**  
  - Supports loading and saving car data files.  
- **GUI Interface:**  
  - Uses Swing components like `JFrame`, `JPanel`, `JLabel`, `JButton`, and `JTabbedPane`.  

---

### 📁 **File Structure:**

| **File Name**               | **Description**                                                |
|------------------------------|----------------------------------------------------------------|
| `AboutDialog.java`           | Displays an information dialog box with app details.           |
| `AddCarPanel.java`           | GUI panel to add new cars to the system.                       |
| `CarSalesSystem.java`        | Main driver class that runs the entire application.            |
| `CarUpdateEvent.java`        | Event class handling car update events.                        |
| `CarDetailsComponents.java`  | Displays detailed car information.                             |
| `SearchByAgePanel.java`      | Panel to search cars by their age.                             |
| `SearchByOtherPanel.java`    | Panel to search cars by price and distance traveled.           |
| `ShowAllCarsPanel.java`      | Displays all cars with navigation buttons.                     |
| `SimpleGUI.java`             | Basic Java Swing GUI example (for demonstration purposes).     |
| `SwingInheritanceExample.java`| Demonstrates inheritance in Swing components.                   |
| `WelcomePanel.java`          | Displays system statistics and a welcome message.              |
| `Manufacturer.java`          | Manages car manufacturers and their associated cars.           |

---

### 🔧 **Technologies Used:**
- **Java** – Core programming language.  
- **Swing & AWT** – For building the GUI.  
- **Event Handling** – For managing user interactions.  
- **File I/O** – To save and load car data.  

---

### 🚀 **How to Run:**
1. **Compile the project:**
```
javac CarSalesSystem.java
```
2. **Run the application:**
```
java CarSalesSystem
```
3. **Usage Instructions:**  
   - Add cars with details like model, manufacturer, year, price, and distance.  
   - Search cars by filters and navigate through the results.  
   - View system statistics on the **Welcome Panel**.

---

### 📊 **Future Enhancements:**
- **Database Integration:**  
  - Store car data in a **database** instead of files.  
- **Advanced Filters:**  
  - Add filters for **fuel type, car color**, and **seating capacity**.  
- **Enhanced GUI:**  
  - Improve the **user interface** with modern styling and themes.  
