set /p version="Enter version (3.1): "

git tag v%version%
git push
git push --tags

cd ..
cd target

github-release release --security-token 96af8e330f450bb0d9ffb65c72145e19a77d47a1 --user kenji89 --repo SecureChatServer --tag v%version%

github-release upload --security-token 96af8e330f450bb0d9ffb65c72145e19a77d47a1 --user kenji89 --repo SecureChatServer --tag v%version% --name SecureChatServer.jar --file SecureChatServer-0.0.1-SNAPSHOT.jar

pause
