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
        microphoneOffTime = 0
    end
end