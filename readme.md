

# 🛒 Price Comparison Script (Amazon vs. Flipkart vs. Nykaa)

## 📌 Overview
This Selenium script automates the process of comparing the price of a product from Amazon with its listings on Flipkart and Nykaa. The script returns the platform offering the lowest price, helping users make smarter purchasing decisions.

---

## ⚙️ Features
- 🟡 **Automated Price Scraping:** Collects prices from Amazon, Flipkart, and Nykaa.  
- 🟢 **Price Comparison:** Identifies the cheapest option among the three platforms.  
- 🟠 **Report Generation:** Displays results in a clean and readable format.  
- 🔵 **Scalable Framework:** Built using Selenium with Page Object Model (POM) structure for easy maintenance.  

---

## 🛠️ Tech Stack
- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Framework:** TestNG (Optional)  
- **Browser:** ChromeDriver  
- **Build Tool:** Maven  

---

## 📂 Project Structure
```
📁 src
 ┣ 📂 main
 ┃ ┗ PriceCompare.java
📄 pom.xml
📄 README.md
```

---

## 🚀 Installation & Setup

### 1️⃣ Prerequisites:
- JDK 17 or higher  
- Maven installed and configured  
- Chrome browser and matching ChromeDriver  

### 2️⃣ Clone the Repository:
```bash
git clone https://github.com/yourusername/price-comparison-selenium.git
cd price-comparison-selenium
```

### 3️⃣ Install Dependencies:
```bash
mvn clean install
```

---

## 🧪 Running the Tests
```bash
mvn test
```

- **Input:** Provide the Amazon product URL through a properties file or as a test parameter.  
- **Output:** Displays the cheapest platform in the console or test report.  

---

## 📝 Sample Test Output:
```
Amazon Price: ₹1,299
Flipkart Price: ₹1,199
Nykaa Price: ₹1,250

Cheapest Option: Flipkart (₹1,199)
```

---

## 📈 Future Enhancements
- ✅ Add support for more e-commerce platforms (e.g., Myntra, Ajio)  
- ✅ Store results in a CSV or JSON file  
- ✅ Include error handling for out-of-stock products  
- ✅ Implement retry mechanisms for failed scrapes  

---

## 📄 License
This project is licensed under the [MIT License](LICENSE).

---
