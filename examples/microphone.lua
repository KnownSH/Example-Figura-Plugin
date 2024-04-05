if type(events["svc.microphone"]) == "Event" then
    events["svc.microphone"] = function ()
        print("help")
    end
end