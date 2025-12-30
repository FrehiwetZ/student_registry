<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Portal | Registration</title>
    <style>
        body {
            background-color: #f3f4f6;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex; align-items: center; justify-content: center;
            height: 100vh; margin: 0;
        }
        .form-container {
            background: #ffffff;
            padding: 32px;
            border-radius: 16px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.05);
            width: 100%;
            max-width: 380px;
        }
        .header-bar {
            height: 4px; width: 60px; background: #8a3ffc;
            margin: 0 auto 24px; border-radius: 2px;
        }
        h2 { text-align: center; color: #111827; margin-bottom: 24px; font-weight: 600; }
        .input-wrapper { margin-bottom: 16px; }
        label { display: block; margin-bottom: 6px; font-size: 14px; color: #4b5563; font-weight: 500; }
        input {
            width: 100%; padding: 12px; border: 1px solid #d1d5db;
            border-radius: 8px; box-sizing: border-box; font-size: 15px;
            transition: all 0.2s; background: #f9fafb;
        }
        input:focus { outline: none; border-color: #8a3ffc; background: #fff; box-shadow: 0 0 0 3px rgba(138, 63, 252, 0.1); }
        button {
            width: 100%; padding: 14px; border: none; border-radius: 8px;
            background: #8a3ffc; color: white; font-weight: 600;
            font-size: 16px; cursor: pointer; transition: background 0.2s;
            margin-top: 8px;
        }
        button:hover { background: #6929c4; }
        .view-link { display: block; text-align: center; margin-top: 20px; color: #8a3ffc; text-decoration: none; font-size: 14px; font-weight: 500; }
    </style>
</head>
<body>
    <div class="form-container">
        <div class="header-bar"></div>
        <h2>Student Registry</h2>
        <form action="register" method="POST">
            <div class="input-wrapper">
                <label>Full Name</label>
                <input type="text" name="name" placeholder="e.g. John Doe" required>
            </div>
            <div class="input-wrapper">
                <label>Email Address</label>
                <input type="email" name="email" placeholder="john@example.com" required>
            </div>
            <div class="input-wrapper">
                <label>Academic Year</label>
                <input type="number" name="year" placeholder="2025" required>
            </div>
            <button type="submit">Submit Registration</button>
        </form>
        <a href="show_all" class="view-link">View Registered Students</a>
    </div>
</body>
</html>