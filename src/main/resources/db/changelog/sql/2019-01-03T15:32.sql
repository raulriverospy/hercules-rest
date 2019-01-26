-- This script insert user and client credentials for oauth2 authentication

--oauth_client_details table
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('barClientIdPassword', '$2a$10$s7rR9qxaUnOJaE3J6ZSICupQxm.xTJhvScmXV.ylsI3AIY5OMXp.q', 
	'bar,read,write', 'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);