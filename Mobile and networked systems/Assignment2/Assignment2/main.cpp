#define CROW_MAIN

#include "shoppingCart.h"
#include "crow_all.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <iostream>
#include <filesystem>

std::string sendFile(std::string filename, std::string directory = "", bool publicFolder = true)
{
	if (directory.length() > 1)
	{
		filename = directory + '/' + filename;
	}
	if (publicFolder){
		filename = "public/" + filename;
	}

	std::cout << "Current working directory: " << std::filesystem::current_path() << std::endl;
	std::cout << "Wanted file: " << std::filesystem::current_path().generic_string() << "/public/" << filename << std::endl;
	std::ifstream in(filename);
	if (in)
	{
		std::ostringstream contents;
		contents << in.rdbuf();
		in.close();
		return contents.str();
	}
	else
	{
		return "not found";
	}
}

int main()
{
	crow::SimpleApp app;
	// if cant read
	if (!shoppingCart::readFromStorage())
	{
		// write empty file, if cant write empty file
		if (!shoppingCart::writeToStorage())
		{
			// must be a permission issue, close
			return 0;
		}
	}

	CROW_ROUTE(app, "/")
	([](const crow::request &req, crow::response &res)
	{ 
		res.write(sendFile("index.html"));
		res.add_header("Content-Type", "text/html");
		res.end(); 
	});

	CROW_ROUTE(app, "/checkout")
	([](const crow::request &req, crow::response &res)
	{
		res.write(sendFile(shoppingCart::storageFile, "", false));
		res.add_header("Content-Type", "text/html");
		res.end();

		// clear the cart after a checkout occurs
		shoppingCart::resetContainer();
	});

	CROW_ROUTE(app, "/addItemToCard/<string>/<int>")
	([](const crow::request &req, crow::response &res, std::string product, int amount)
	{
		std::cout << "Adding: " << amount << ' ' << product << "'s" << std::endl;
		shoppingCart::setItem(product, amount);
		res.write("Item added successfully");
		res.add_header("Content-Type", "text/plain");
		res.end();
	});

	CROW_ROUTE(app, "/getPage/<string>")
	([](const crow::request &req, crow::response &res, std::string filename)
	 { 
		res.write(sendFile(filename));
		res.add_header("Content-Type", "text/html");
		res.end(); 
	});

	CROW_ROUTE(app, "/getImage/<string>")
	([](const crow::request &req, crow::response &res, std::string filename)
	 { 
		res.write(sendFile(filename, "images"));
		res.add_header("Content-Type", "image/png");
		res.end(); 
	});

	CROW_ROUTE(app, "/getScript/<string>")
	([](const crow::request &req, crow::response &res, std::string filename)
	 { 
		res.write(sendFile(filename, "scripts"));
		res.add_header("Content-Type", "application/javascript");
		res.end(); 
	});

	CROW_ROUTE(app, "/getStyle/<string>")
	([](const crow::request &req, crow::response &res, std::string filename)
	 { 
		res.write(sendFile(filename, "styles"));
		res.add_header("Content-Type", "text/css");
		res.end(); 
	});

	CROW_ROUTE(app, "/login").methods(crow::HTTPMethod::Post)
	([](const crow::request &req, crow::response &res){
		res.add_header("Content-Type", "text/plain");

		const char* user_ptr = req.url_params.get("username");
		const char* pass_ptr = req.url_params.get("password");

		if (user_ptr == nullptr || pass_ptr == nullptr) {
			res.code = 400;
			res.write("Missing username or password query parameters");
			res.end();
			return;
		}

		std::string username(user_ptr);
		std::string password(pass_ptr);

		if (username == "admin" && password == "123") {
			res.code = 202;
			res.write("Accepted");
		} else {
			res.code = 401;
			res.write("Unauthorized");
		}
		res.end();
		return;
});

	app.port(23500).multithreaded().run();
	return 1;
}
