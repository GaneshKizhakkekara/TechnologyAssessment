Vagrant.require_version ">= 1.7.0"

Vagrant.configure(2) do |config|

  config.vm.box = "centos/7"


  config.ssh.insert_key = false


  config.vm.define :database do |cfg|
        cfg.vm.network :private_network, ip: "192.171.11.10"
        cfg.vm.provider :virtualbox do |v|
            v.name = "database"
        cfg.vm.provision :shell, :path => "database.sh"
        end
    end

  config.vm.define :appvm do |cfg|
        cfg.vm.network :private_network, ip: "192.171.11.11"
        cfg.vm.provider :virtualbox do |v|
            v.name = "appvm"
        cfg.vm.provision :shell, :path => "appvm.sh"
        end
    end

  config.vm.define :haproxy do |cfg|
        cfg.vm.network :private_network, ip: "192.171.11.9"
        cfg.vm.provider :virtualbox do |v|
            v.name = "haproxy"
        cfg.vm.provision :shell, :path => "haproxy.sh"
        cfg.vm.provision "file", source: "/root/Ganesh_ShortestPath/haproxy.cfg", destination: "/etc/haproxy/haproxy.cfg"
        cfg.vm.provision :shell, :path => "haproxystart.sh"
        end
    end
end