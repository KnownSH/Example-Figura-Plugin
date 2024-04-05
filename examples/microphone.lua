local microphoneOffTime = 0
local isMicrophoneOn = false

function events.tick()
    local previousMicState = isMicrophoneOn

    microphoneOffTime = microphoneOffTime + 1
    isMicrophoneOn = microphoneOffTime <= 2

    if previousMicState ~= isMicrophoneOn then
        print(isMicrophoneOn and "Speaking" or "not speaking")
    end
end

if type(events["svc.microphone"]) == "Event" then
    events["svc.microphone"] = function ()
<<<<<<< HEAD
        microphoneOffTime = 0
=======
        print("player is currently talking on mic")
>>>>>>> 6b93e15c3b8dcf6207d9bbb3db6f778a2ff7e3d8
    end
end
