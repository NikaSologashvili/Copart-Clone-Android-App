# 🚗 Copart Clone - Android Mobile App (Java)

A feature-rich **auction and bidding platform** for used and salvaged vehicles — inspired by [Copart](https://www.copart.com). Built using native Android (Java), Firebase backend, and modern Android UI components.

---

## 📱 Features

- 🔍 **Browse Vehicles**: Search and filter by make, model, year, damage type, and location.
- 🛒 **Bidding System**: Real-time bidding interface with bid history.
- ❤️ **Watchlist**: Save vehicles to your watchlist for later tracking.
- 🔐 **User Authentication**: Firebase Auth for login, signup, and password reset.
- 📦 **Vehicle Details Page**: Full details with images, VIN, auction date, location, and more.
- 🔔 **Push Notifications**: Get notified on auctions, wins, or vehicle updates.
- 📊 **Admin Panel (Optional)**: Add/edit vehicle listings (if implemented).

---

## 🛠️ Tech Stack

| Component        | Technology         |
|------------------|--------------------|
| Language         | Java               |
| UI Framework     | Android XML, Material Components |
| Backend          | Firebase (Auth, Firestore, Storage, FCM) |
| Architecture     | MVVM               |
| Image Loading    | Glide / Picasso    |
| Dependency Injection | Dagger / Hilt (optional) |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Electric Eel or newer)
- Java 8+
- Firebase Project (Firestore, Auth, Storage, FCM)

### Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/copart-clone-android.git
   cd copart-clone-android
   ```

2. **Open in Android Studio**:
   - File → Open → Select the project folder

3. **Connect Firebase**:
   - Tools → Firebase → Connect to Firebase
   - Enable Authentication, Firestore, Storage, and Cloud Messaging

4. **Add `google-services.json`**:
   - Download from Firebase Console → Add to `app/` directory

5. **Build and Run**:
   - Run on emulator or physical device

---

## 📂 Project Structure

```
com.example.copartclone
├── auth/              // Login, Register, Forgot Password
├── ui/
│   ├── home/          // Vehicle listing & search
│   ├── details/       // Vehicle details screen
│   ├── bid/           // Bidding UI
│   └── watchlist/     // Saved vehicles
├── models/            // Data classes
├── adapters/          // RecyclerView adapters
├── firebase/          // Firebase interaction classes
└── utils/             // Constants, helpers, etc.
```

---


---

## 📌 TODOs

- [ ] Implement Admin Panel (Web or In-App)
- [ ] Add VIN decoder API integration
- [ ] Dark Mode support
- [ ] Unit & UI Testing

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to fork the repo and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
